from random import randrange
# Initialize a Tic-Tac-Toe Board
board = ["-","-","-",
         "-","-","-",
         "-","-","-"]

save_inputs = []

# Set a bolean to check win
check_win = False

# Ask who goes first
first_or_second_turn = None

count = 0
# Set the counter to take turn
def decide_turn():
    global count
    don = True

    while don == True:
        user_decide = input("Do you want to take the first turn? (y/n) ")
        if user_decide == "Y" or user_decide == "y":
            count = 0
            don = False
        elif user_decide == "N" or user_decide == "n":
            count = 1
            don = False
        elif user_decide != "Y" and user_decide != "y" and user_decide != "N" and user_decide != "n":
            print("Invalid input. Choose either y or n.")
            True

# Make the board with values
def display_board():
    print(board[0] + "|" + board[1]+ "|" + board[2])
    print(board[3] + "|" + board[4]+ "|" + board[5])
    print(board[6] + "|" + board[7]+ "|" + board[8])

# A fucntion to run the game
def play_game():
    decide_turn()
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
                position = input("\nPlease choose a position from 1 to 9: ")
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
                    print("\n[Your move]")
                    
                    if position not in save_inputs:
                        decide = False
                    elif position in save_inputs:
                        decide = True
                        print("The spot is already taken. Please try other spots.")


        save_inputs.append(position)
        board[position] = "O"
        display_board()
    else:
        # Display tictactoe board
        #display_board()
        print("\n[AI's move]")
        while decide==True:
            position = randrange(0,8)
            if position not in save_inputs:
                decide = False
            elif position in save_inputs:
                decide = True

        save_inputs.append(position)
        board[position] = "X"
        display_board()
    
    count+=1

# Check if the player won, lost, or tie
def check_win():
    global check_win
    # Check X's win
    if board[0] == "X" and board[1] == "X" and board[2] == "X":
        print("\nAI won the game!")
        check_win = True
        display_board()
    elif board[3] == "X" and board[4] == "X" and board[5] == "X":
        print("\nAI won the game!")
        check_win = True
        display_board()
    elif board[6] == "X" and board[7] == "X" and board[8] == "X":
        print("\nAI won the game!")
        check_win = True
        display_board()
    elif board[0] == "X" and board[3] == "X" and board[6] == "X":
        print("\nAI won the game!")
        check_win = True
        display_board()
    elif board[1] == "X" and board[4] == "X" and board[7] == "X":
        print("\nAI won the game!")
        check_win = True
        display_board()
    elif board[2] == "X" and board[5] == "X" and board[8] == "X":
        print("\nAI won the game!")
        check_win = True
        display_board()
    elif board[0] == "X" and board[4] == "X" and board[8] == "X":
        print("\nAI won the game!")
        check_win = True
        display_board()
    elif board[2] == "X" and board[4] == "X" and board[6] == "X":
        print("\nAI won the game!")
        check_win = True
        display_board()
    
    # Check O's win
    elif board[0] == "O" and board[1] == "O" and board[2] == "O":
        print("\nYou won the game!")
        check_win = True
        display_board()
    elif board[3] == "O" and board[4] == "O" and board[5] == "O":
        print("\nYou won the game!")
        check_win = True
        display_board()
    elif board[6] == "O" and board[7] == "O" and board[8] == "O":
        print("\nYou won the game!")
        check_win = True
        display_board()
    elif board[0] == "O" and board[3] == "O" and board[6] == "O":
        print("\nYou won the game!")
        check_win = True
        display_board()
    elif board[1] == "O" and board[4] == "O" and board[7] == "O":
        print("\nYou won the game!")
        check_win = True
        display_board()
    elif board[2] == "O" and board[5] == "O" and board[8] == "O":
        print("\nYou won the game!")
        check_win = True
        display_board()
    elif board[0] == "O" and board[4] == "O" and board[8] == "O":
        print("\nYou won the game!")
        check_win = True
        display_board()
    elif board[2] == "O" and board[4] == "O" and board[6] == "O":
        print("\nYou won the game!")
        check_win = True
        display_board()
    else:
        #Check draw
        if all(ele != "-" for ele in board):
            print("\nThe game ended draw!")
            check_win = True
            display_board()

# Run the play_game function to run this program
play_game()
