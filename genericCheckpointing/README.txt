Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code

ant -buildfile src/build.xml run -Darg0="MODE" -Darg1=N -Darg2=output.txt

example: 
ant -buildfile src/build.xml run -Darg0="serdeser" -Darg1=20 -Darg2=output.txt
ant -buildfile src/build.xml run -Darg0="deser" -Darg1=20 -Darg2=output.txt

-----------------------------------------------------------------------

## To create tarball for submission
tar -czvf aravindhan_venkituswamy_assign_6.tar.gz --exclude=.* aravindhan_venkituswamy_assign_6

-----------------------------------------------------------------------

## To unzip tarball for execution
tar -xvf aravindhan_venkituswamy_assign_6.tar.gz

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 12/11/2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

vector array is used with O(n) time complexity

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).
