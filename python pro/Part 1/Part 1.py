# I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.  
# Any code taken from other sources is referenced within my code solution.

# Student ID:w1830145
# Date:17/04/2021

#user inputs
print("-"*75)
pass_mark=int(input('please enter your credit at pass:'))
print()
defer_mark=int(input('please enter your credit at defer:'))
print()
fail_mark=int(input('please enter your credit at fail:'))
print()
print("."*60)


#process
if pass_mark==120:
  print('Progress')
elif pass_mark==100:
  print('Progress(module trailer)')
elif pass_mark in (80,60):
  print('Do not progress-module retriever')
elif pass_mark==40:
  if fail_mark==80:
    print('Exclude')
  else:
    print('Do not progress-module retriever')
elif pass_mark==20:
  if fail_mark in (80,100):
   print('Exclude')
  else:
    print('Do not pregress-module retriever')
elif pass_mark==00:
  if fail_mark in (80,100,120):
    print('Exclude')
  else:
    print('Do not pregress-module retriver')
  print("-"*75)

