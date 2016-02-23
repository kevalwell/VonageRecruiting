function myParseInt(s) {
   s_trimmed = s.trim();

   var base_of_ten = 1;
   var parsed_int = 0;
   for (var i = s_trimmed.length - 1; i >= 0; i--) {
      //Converts int chars to int for arithmetic operations
      var digit = s_trimmed.charAt(i) - '0';

      // If character not 0-9, return NaN
      if (digit == NaN) {
         return NaN;
      }

      // Update return value (parsed_int)
      parsed_int += base_of_ten * digit;
      base_of_ten *= 10;
   }

   return parsed_int;
}

console.log(myParseInt("1"));
console.log(myParseInt("  1 "));
console.log(myParseInt("08"));
console.log(myParseInt("5 friends"));
console.log(myParseInt("16.5"));
