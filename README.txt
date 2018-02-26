[Date: 12/11/2017]
[By: Aravindan Venkituswamy]

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
tar -czvf genericCheckpointing.tar.gz --exclude=.* genericCheckpointing

-----------------------------------------------------------------------

## To unzip tarball for execution
tar -xvf genericCheckpointing.tar.gz

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

vector array is used with O(n) time complexity

-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).
