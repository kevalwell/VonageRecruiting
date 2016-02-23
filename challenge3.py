"""
challenge3.py: Defines the break_chocolate() function, which returns the
                  minimum number of breaks for a chocolate bar given its width
                  and length. Also includes a UI asking the user for the length
                  and width of a chocolate bar.
"""

__author__      = "Sean Yun"


def break_chocolate(n, m):
   return n*m - 1 if (n > 1 and m > 1) else 0

while True:
   try:
      length_input = raw_input("Enter length of chocolate bar: ")

      # Check if input is an integer value
      if int(length_input) - float(length_input) == 0:
         length = int(length_input)
      break
   except ValueError:
      print "That was not an integer.  Please try again..."

while True:
   try:
      width_input = raw_input("Enter width of chocolate bar: ")

      # Check if input is an integer value
      if int(width_input) - float(width_input) == 0:
         width = int(width_input)
      break
   except ValueError:
      print "That was not an integer.  Please try again..."

print "The minimum number of breaks required is " + str(break_chocolate(length, width)) + "."


"""
Test cases
# print break_chocolate(1, 1)
# print break_chocolate(5, 5)
# print break_chocolate(7, 4)
"""