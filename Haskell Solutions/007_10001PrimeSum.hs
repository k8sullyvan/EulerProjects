primes :: [Int]
primes = sieve [2..]
  where
    sieve (p:xs) = p : sieve [x |x <- xs, mod x p > 0]

getPrime :: Int -> Int
getPrime x = primes !! (x-1)

-- getPrime 6 = 13
-- getPrime 10001 = 104743