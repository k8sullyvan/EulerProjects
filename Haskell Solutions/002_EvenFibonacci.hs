-- Where m is the max value and s is the current sum
sumEvnFib	:: Int -> (Int, Int, Int) -> Int
sumEvnFib m (a,b,s) = if a+b<m 
			then sumEvnFib m (a+2*b, ((2*a)+(3*b)), s+a+b)
			else s

--Starting at 0 with the max set at 4,000,000
-- sumEvnFib 4000000 (1, 1, 0)
-- 4613732