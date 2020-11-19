decide2 = True
decide3 = True

while decide2 == True:
    try:
        while decide3 == True:
            user_input = input("\nPress 1 to play single mode with AI, \nor press 2 to play dual mode.\n")

            input_received = int(user_input)

            if input_received != 1 and input_received != 2:
                print("Invalid input. Please choose either 1 or 2.\n")
                decide3 == True
            else:
                decide = True

                while decide == True:
                    if input_received == 1:
                        print("\n<Playing Single Mode>\n")
                        import tictactoe_single_AI       
                        exec("tictactoe_single_AI")
                        decide = False  
                        decide3 = False      
                        

                    elif input_received == 2:
                        print("\n<Playing Dual Mode>\n")
                        import tictactoe_dual       
                        exec("tictactoe_dual")
                        decide = False
                        decide3 = False

        decide2 = False
    except ValueError:
        decide2 = True
        print("String value is not allowed.")