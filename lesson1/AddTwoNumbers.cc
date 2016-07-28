//http://www.inference.phy.cam.ac.uk/teaching/comput/C++/examples/AddTwoNumbers.shtml
// AddTwoNumbers.cc
// Computes the sum of two numbers inputed at the keyboard.

#include <iostream>
using namespace std;

int main()
{
  int a, b, total ;
   
   cout << "Input numbers to be added: " << endl;
   cin >> a >> b ;
   total = a + b ;
   cout << "The sum is " << total << endl;
   return 0;
}
