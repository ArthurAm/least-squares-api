### Linear least-squares API

Simple Spring API with just one endpoint, that allows you to calculate a least-squares regression line by X and Y point data.

**Usage**:

Send a POST HTTP request to /calculate_ls with X and Y JSON data looks like:
```
{
"x": ["1", "2", "3"],
"y": ["7.333", "14.667", "7.333"]
}
```
And get JSON response with that format
```
{
"slope": {
    "coefficient": "4.7369",
    "standart_error": "4.234",
    "t_value": "1.1187"
},
"intercept": {
    "coefficient": "9.777"
},
"standart_error": "5.988",
"r_squared": "1.251"
}
```
with linear regression parameters.

Detailed method description [wiki](https://en.wikipedia.org/wiki/Least_squares)