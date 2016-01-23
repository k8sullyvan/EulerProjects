--Squaring a series and adding them them
sqrSum :: Int -> Int
sqrSum x = sum ([a^2 | a <- [1..x]])

--Summing a series and squaring the result
sumSqr :: Int -> Int 
sumSqr x = sum([1..x]) ^ 2

--Difference between the two
sumSqrDif :: Int -> Int
sumSqrDif x = sumSqr x - sqrSum x

-- sumSqrDif 10 = 2640
-- sumSqrDif 100 = 25164150