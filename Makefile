# Update these variables to match the locations
JUNIT_JAR=lib/org.junit_4.13.0.v20200204-1500.jar
HAMCREST_JAR=lib/org.hamcrest.core_1.3.0.v20180420-1519.jar
ANTLR_JAR=lib/antlr-4.9.2-complete.jar

# These variables should not need to be changed
GRAMMAR_NAME=LightPython
GRAMMAR=${GRAMMAR_NAME}.g4
TEST_CLASSPATH=${JUNIT_JAR}:${HAMCREST_JAR}:${ANTLR_JAR}
LPY_SCRIPT_DIR=lpython
PY_SCRIPT_DIR=python

# SCRIPTS=ifthenelsewhile.lpy
SCRIPTS= boolean.lpy if_simple.lpy ifthenelsewhile.lpy list.lpy listvar.lpy op.lpy simple.lpy strings.lpy
SCRIPTS_P= boolean.py if_simple.py ifthenelsewhile.py list.py listvar.py op.py simple.py strings.py
TREES_DIR=parseTrees
# Choosing build instead of bin to avoid conflicts with Eclipse
BUILD_DIR=build
SRC_FOLDERS=edu/sjsu/lpython
PACKAGE_NAME=edu.sjsu.lpython
GEN_SRC_BASE_DIR=generatedSrc
PARSER_SRC_FOLDERS=edu/sjsu/lpython/parser
GEN_SRC_DIR=${GEN_SRC_BASE_DIR}/${PARSER_SRC_FOLDERS}
PARSER_PACKAGE_NAME=edu.sjsu.lpython.parser
ZIP_FILE=solution.zip

.PHONY: all test run clean spotless generate
all: generate
	mkdir -p ${BUILD_DIR}/${SRC_FOLDERS}
	javac -cp ${TEST_CLASSPATH} -d ${BUILD_DIR} src/${SRC_FOLDERS}/*.java testSrc/${SRC_FOLDERS}/*.java ${GEN_SRC_DIR}/*.java

generate: ${GRAMMAR}
	mkdir -p ${GEN_SRC_DIR}
	java -jar ${ANTLR_JAR} -no-listener -visitor ${GRAMMAR} -o ${GEN_SRC_DIR}

parse:
	mkdir -p ${TREES_DIR}
	$(foreach script, ${SCRIPTS}, java -cp ${BUILD_DIR}:${ANTLR_JAR} org.antlr.v4.gui.TestRig \
		${PARSER_PACKAGE_NAME}.${GRAMMAR_NAME} file_input -gui ${LPY_SCRIPT_DIR}/${script} > ${TREES_DIR}/${script}.tree;)

test:
	java -cp ${BUILD_DIR}:${TEST_CLASSPATH} org.junit.runner.JUnitCore ${PACKAGE_NAME}.ExpressionTest
	java -cp ${BUILD_DIR}:${TEST_CLASSPATH} org.junit.runner.JUnitCore ${PACKAGE_NAME}.StatementTest

run:
	$(foreach script, ${SCRIPTS}, echo "Running ${LPY_SCRIPT_DIR}/${script}"; \
		java -cp ${BUILD_DIR}:${ANTLR_JAR} ${PACKAGE_NAME}.Interpreter ${LPY_SCRIPT_DIR}/${script};)

runp:
	$(foreach script, ${SCRIPTS_P}, echo "Running ${PY_SCRIPT_DIR}/${script}"; \
		python ${PY_SCRIPT_DIR}/${script};)


${ZIP_FILE}:
	zip ${ZIP_FILE} src/${SRC_FOLDERS}/*.java ${GRAMMAR}

clean:
	-rm -r ${BUILD_DIR}

spotless: clean
	-rm ${ZIP_FILE}
	-rm -r ${GEN_SRC_BASE_DIR}
	-rm -r ${TREES_DIR}


