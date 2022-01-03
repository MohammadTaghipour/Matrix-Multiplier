## Overview

This program is a calculator for multiplying two square matrices. All you have to do is create an instance of the multiplier class and enter an Integer value in the constructor as the length of the matrix.
This program also has the ability to save the result in a text file after performing the calculations and display it to the user.

## How to use?!

```Java
        Multiplier matrixMultiplier = new Multiplier(4);
        matrixMultiplier.initializeMatrix();
        matrixMultiplier.printMatrix(matrixMultiplier.getA());
        matrixMultiplier.printMatrix(matrixMultiplier.getB());
        matrixMultiplier.doMultiplication();
        matrixMultiplier.saveResultInTextFile();
        matrixMultiplier.openFile();
```
