# Integration Testing

**Task**

Perform integration testing of a program that calculates a system of functions

`x <= 0 : csc(x)`

`x > 0 : (((((log_5(x) / log_10(x)) ^ 3) ^ 3) + ln(x)) ^ 3)`

**Requirements**
1. All the functions that make up the system (both trigonometric and logarithmic) must be expressed through the base functions (trigonometric depends on the variant; logarithmic is the natural logarithm).
2. Both "basic" functions (in the example above, sin(x) and ln(x)) must be realized using a series expansion with a given error. Using trigonometric / logarithmic transformations to simplify functions is NOT allowed.
3. Table stubs must be implemented for EVERY module. At the same time, it is necessary to find the area of allowable values of functions, and, if necessary, to determine the interdependent points in the modules.
4. The developed application must allow to output the values produced by any module of the system to a csv file of the form "X, Results of module (X)", allowing to change arbitrarily the increment step of X. The separator in the csv file can be used arbitrarily.