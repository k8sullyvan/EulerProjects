-- Sum of multiples of 3 and 5 less than 1000 (inclusive)
sum3and5  :: Int -> Int 
sum3and5 x = sum [a | a<- [1..x], mod a 3 == 0 || mod a 5 == 0]

sum3n5  :: Int -> Int 
sum3n5 x = sum (filter (\ a -> mod a 3 == 0 || mod a 5 == 0) [1..x])
