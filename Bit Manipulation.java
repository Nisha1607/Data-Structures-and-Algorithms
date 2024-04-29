1. one's complement - flip all the bits of binary representation of a number.

2. AND : all true then true , one false everything is false.

3. OR : 1 true means true , all false means everything false.

4.XOR : same same then 0, diflent diflen then 1.

5. >> : Right shift binary representation of a number by k. (n/2^k)  eg. 13>>1 will be calculated as 13/2. similary. n>>k will be n/2^k.

6. << : Left shift binary representation of a number by k. (n*2^k)  eg. 13<<1 will be calculated as 13*2. similary. n<<k will be n*2^k.

7. To check for odd number : n&1 

8. To turn off rightmost bit : N & (N-1)

9. Count set bits in a number : while(n!=0){
                                  n=n&(n-1);
                                  cnt++;
                              }
                          
