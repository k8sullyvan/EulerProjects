sumEvenFib				:: (Int, Int, Int) -> Int
sumEvenFib (a,b,s) 		= if a+b<4000000 
							then evenFibVariableInput (a+b+b, a+a+b+b+b, s+a+b)
							else s

evenFib 				:: Int
evenFib 				= sumEvenfib (1, 1, 0)

