# Calculates the number of breaks needed
# Procedure is as follows: make n-1 cuts of the chocolate
# so that it has n slices. For each slice, cut m-1 times.
# Hence, in total we have (n-1) + n(m-1) = nm-1
# When m or n = 0, we can just return 0.
def break_chocolate(n, m):
	if (n == 0 or m == 0):
		return 0
	else:
		return n*m - 1

print("Number of breaks: ", break_chocolate(5, 5));
