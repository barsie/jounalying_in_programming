#! /bin/bash

# This checks if the number of arguments is correct
# If the number of arguments is incorrect ( $# != 2) print error message and exit
if [[ $# != 2 ]]
then
  echo "backup.sh target_directory_name destination_directory_name"
  exit
fi

# This checks if argument 1 and argument 2 are valid directory paths
if [[ ! -d $1 ]] || [[ ! -d $2 ]]
then
  echo "Invalid directory path provided"
  exit
fi

# [TASK 1]
targetDirectory="/home/toly"
destinationDirectory="/home/toly"

# [TASK 2]
echo "The value of the targetDirectory is $targetDirectory"
echo "The value of the destinationDirectory is $destinationDirectory"

# [TASK 3] Define a variable called currentTS as the current timestamp, expressed in seconds.
currentTS=$(date +%s)

# [TASK 4] Define a variable called backupFileName to store the name of the archived and compressed backup file that the script will create.
backupFileName="backup-$currentTS.tar.gz"

# We're going to:
  # 1: Go into the target directory
  # 2: Create the backup file
  # 3: Move the backup file to the destination directory

# To make things easier, we will define some useful variables...

# [TASK 5] Define a variable called origAbsPath with the absolute path of the current directory as the variable's value.
origAbsPath= $(pwd)
origAbsPath= `pwd`

# [TASK 6] Define a variable called destAbsPath whose value equals the absolute path of the destination directory.
cd $destinationDirectory || exit 1
destAbsPath=$(pwd)

cd $destinationDirectory
destAbsPath=`pwd`

# [TASK 7] Change directories from the current working directory to the target directory targetDirectory
# cd "$origAbsPath" || exit 1
cd "$targetDirectory" || exit 1

# [TASK 8] find files that have been updated within the past 24 hours
yesterdayTS=$(($currentTS - 24 * 60 * 60))

declare -a toBackup

for file in $(ls -a) # [TASK 9] In the for loop, use the wildcard to iterate over all files and directories in the current folder.
  # [TASK 10] you want to check whether the $file was modified within the last 24 hours.
  if (( $(date -r "$file" +%s) -gt $yesterdayTS))
  then
    # [TASK 11]
    toBackup+=("$file")
  fi
done

# [TASK 12] compress and archive the files, using the $toBackup array of filenames, to a file with the name backupFileName.
tar -czvf "$backupFileName" "${toBackup[@]}"

# [TASK 13]Move the file backupFileName to the destination direction directorry located at destAbsPath
mv "$backupFileName" "$destAbsPath"

# Congratulations! You completed the final project for this course!

