a = True
b = False
if a and b:
  b = 3
else:
  b = True
  if a and b:
    a = 1
    b = 2
print(a) 
print(b)
