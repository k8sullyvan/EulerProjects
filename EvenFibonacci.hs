evenFibVariableInput				:: (Int, Int, Int) -> Int
evenFibVariableInput (a,b,s) 		= if a+b<4000000 
										then evenFibVariableInput (a+b+b, a+a+b+b+b, s+a+b)
										else s

evenFib 							:: Int
evenFib 							= evenFibVariableInput (1, 1, 0)

