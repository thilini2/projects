# student ID : 20200476
# Name : Thilini Abeywickrama

# to get random word
import random
#connect to the database
import Database

 
def print_game_status(remaining_guesses):
    mistakes ==  len(words)-1
    print("word: ",end='')

    for element in guesses:
        print(f"{element}",end='')
    print(f"\nYou have {remaining_guesses} turns remain")    

# word list
words = ['elephant','apple','circle','square','rabbit','mouse','keyboard','fan','frock','frog','dog','cat','watermelon','chair','table','door','bag','rat','house','radio']

mistakes = 0

status = ""
# this is for chossing one word and count turns player have
def startgame():
    mistakes = 0
    status = ""
    word_index = random.randint(0, len(words)-1)
    remaining_guesses = len(words[word_index])
    word = words[word_index].upper()

    

    turns_provide = len(word)
    for i in range(len(word)):
        guesses.append('_ ')

    game_over = False

    while not game_over:

        print_game_status(remaining_guesses)

    # inputs
        user_input = input("please enter a letter : ")

        if not user_input:
            print("That's not a valid input.please try again")
        else:
            letter = user_input[0].upper()
            if letter in word:
                for i in range(len(word)):
                    if word[i] == letter:
                        guesses[i] = letter
                        
                if '_' not in guesses:
                    game_over = True
            else:
                print("Sorry, that's not part of the word")
                remaining_guesses -= 1
                mistakes += 1
                if mistakes == len(words[word_index]):
                    game_over = True
      # win lost status          
    if mistakes == len(words[word_index]):
        status = "Loss"
        print_game_status(remaining_guesses)
        print(f"Sorry,You lost. The word is : {word}")
    else:
    
        status = "Win"
    
        print("Congratulations......You won!")
        print(f"The word is : {word}")
        
    Database.insert_data(name,word,turns_provide,remaining_guesses,status)
    
 # inputs      
name = input("Enter your name : ")
print("Hello", name + "!")
print("Let's play hangman.....")

# this is for menu
while True:
    print()
    print("Welcome to Hangman")
    print(" ")
    print("__Menu__")
    print("")
    print(" A. Play ")
    print(" B. View History")
    print(" C. Exit")
    I = input("Enter your Menu Letter : ")
    if I == "A":
        guesses = []
        startgame()
  
    elif I == "B":
        Database.display_data()
    elif I == "C":
        print("Game End!")
        break
