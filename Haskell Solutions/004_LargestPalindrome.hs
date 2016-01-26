isPalin	   :: [Int] -> Bool
isPalin []  = True
isPalin [x] = True
isPalin (x:xs) 	= x == (last xs) && isPalin (init xs)

-- Returns the number as a list in reverse order
-- Note Palindromic numbers are not effected by this
intList  :: Int -> [Int]
intList 0 = []
intList x = mod x 10 : intList (div x 10)

--Decides if a given integer is a palindrom or not
isPalindrome :: Int -> Bool
isPalindrome x = isPalin (intList x)

getMaxPal :: Int
getMaxPal = maximum [a*b | a <- [100..999], b <- [100..999], isPalindrome (a*b)]