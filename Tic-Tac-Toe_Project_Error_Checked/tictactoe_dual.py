# Initialize a Tic-Tac-Toe Board
board = ["-","-","-",
         "-","-","-",
         "-","-","-"]

# Set a bolean to check win
check_win = False

#Save inputs
save_inputs = []

# Set the counter to take turn
count = 0

# Make the board with values
def display_board():
    print(board[0] + "|" + board[1]+ "|" + board[2])
    print(board[3] + "|" + board[4]+ "|" + board[5])
    print(board[6] + "|" + board[7]+ "|" + board[8])

# A fucntion to run the game
def play_game():
    while check_win != True:
        # Run the handle turn function
        handle_turn()
        # Run the check_win function
        check_win()
        
# Decide who's turn the current round
def handle_turn():
    global count
    decide = True

    if count % 2 == 0:
        # Display tictactoe board
        #display_board()
        while decide==True:
            try:
                print("\n[Player 1's turn]")
                position = input("Please choose a position from 1 to 9: ")
                position = int(position)
            except ValueError:
                decide = True
                print("String value is not allowed. Please choose from 1 to 9.\n")
            
            if isinstance(position, int):
                position = position - 1
                if not (position >= 0 and position < 9):
                    print("Invalid input. Please choose from 1 to 9.\n")
                    True
                else:
                    print("\n[Player 1's choice]")
                    
                    if position not in save_inputs:
                        decide = False
                    elif position in save_inputs:
                        decide = True
                        print("The spot is already taken. Please try other spots.")


        save_inputs.append(position)
        board[position] = "O"
        display_board()
    elif count % 2 != 0:
        # Display tictactoe board
        #display_board()
        while decide==True:
            try:
                print("\n[Player 2's turn]")
                position = input("Please choose a position from 1 to 9: ")
                position = int(position)
            except ValueError:
                decide = True
                print("String value is not allowed. Please choose from 1 to 9.\n")
            
            if isinstance(position, int):
                position = position - 1
                if not (position >= 0 and position < 9):
                    print("Invalid input..... Please choose from 1 to 9.\n")
                    True
                else:
                    print("\n[Player 2's choice]")
                    
                    if position not in save_inputs:
                        decide = False
                    elif position in save_inputs:
                        decide = True
                        print("The spot is already taken. Please try other spots.")

        save_inputs.append(position)
        board[position] = "X"
        display_board()
    
    count+=1    

# Check if the player won, lost, or tie
def check_win():
    global check_win
    if board[0] == "X" and board[1] == "X" and board[2] == "X":
        print("Player 2 won the game!")
        check_win = True
        display_board()
    elif board[3] == "X" and board[4] == "X" and board[5] == "X":
        print("Player 2 won the game!")
        check_win = True
        display_board()
    elif board[6] == "X" and board[7] == "X" and board[8] == "X":
        print("Player 2 won the game!")
        check_win = True
        display_board()
    elif board[0] == "X" and board[3] == "X" and board[6] == "X":
        print("Player 2 won the game!")
        check_win = True
        display_board()
    elif board[1] == "X" and board[4] == "X" and board[7] == "X":
        print("Player 2 won the game!")
        check_win = True
        display_board()
    elif board[2] == "X" and board[5] == "X" and board[8] == "X":
        print("Player 2 won the game!")
        check_win = True
        display_board()
    elif board[0] == "X" and board[4] == "X" and board[8] == "X":
        print("Player 2 won the game!")
        check_win = True
        display_board()
    elif board[2] == "X" and board[4] == "X" and board[6] == "X":
        print("Player 2 won the game!")
        check_win = True
        display_board()
    
    elif board[0] == "O" and board[1] == "O" and board[2] == "O":
        print("Player 1 won the game!")
        check_win = True
        display_board()
    elif board[3] == "O" and board[4] == "O" and board[5] == "O":
        print("Player 1 won the game!")
        check_win = True
        display_board()
    elif board[6] == "O" and board[7] == "O" and board[8] == "O":
        print("Player 1 won the game!")
        check_win = True
        display_board()
    elif board[0] == "O" and board[3] == "O" and board[6] == "O":
        print("Player 1 won the game!")
        check_win = True
        display_board()
    elif board[1] == "O" and board[4] == "O" and board[7] == "O":
        print("Player 1 won the game!")
        check_win = True
        display_board()
    elif board[2] == "O" and board[5] == "O" and board[8] == "O":
        print("Player 1 won the game!")
        check_win = True
        display_board()
    elif board[0] == "O" and board[4] == "O" and board[8] == "O":
        print("Player 1 won the game!")
        check_win = True
        display_board()
    elif board[2] == "O" and board[4] == "O" and board[6] == "O":
        print("Player 1 won the game!")
        check_win = True
        display_board()
    else:
        if all(ele != "-" for ele in board):
            print("The game ended draw!")
            check_win = True
            display_board()

# Run the play_game function to run this program
play_game()
