#!/bin/bash

# move all java files (if any exist) from root to all_problems
count=`ls -1 *.java 2>/dev/null | wc -l`
if [ $count != 0 ]
then
	echo "New Java files found, moving to central folder"
	mv *.java all_problems/
fi

# extract difficulty from each java file
# convert to lowercase and copy into corresponding folder
for file in all_problems/*; do
	difficulty=`head -1 $file | cut -d' ' -f2`
	lowercase=`echo $difficulty | awk '{print tolower($0)}'`
	cp $file by_difficulty/$lowercase/ 
	echo "Copied $file into by_difficulty/$lowercase/"
done


echo "Done sorting"
