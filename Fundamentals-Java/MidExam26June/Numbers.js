function numbers(arr){
    let commandCount = 1
    let numArr = arr[0].split(" ")

    let commandLine = arr[commandCount]

    while (commandLine !== "Finish"){
        let command = commandLine.split(" ")[0]
        let value = commandLine.split(" ")[1]

        switch (command){
            case "Add":
                numArr.push(value)
                break
            case "Remove":
                for (let index = 0; index < numArr.length; index++) {
                    if (numArr[index] === value){
                        numArr.splice(index, 1)
                        break
                    }

                }
                break
            case "Replace":
                let replacement = commandLine.split(" ")[2]
                let toReplace = numArr.indexOf(value)
                if (numArr.includes(value)){
                    numArr.splice(toReplace, 1, replacement)
                }
                break
            case "Collapse":
                for (let index = 0; index < numArr.length; index++) {
                    if (numArr[index] < value){
                        numArr.splice(index, 1)
                    }
                }
                break
        }

        commandCount++
        commandLine = arr[commandCount]
    }
    console.log(numArr.join(" "))
}

numbers(["5 9 70 -56 9 9",
    "Replace 9 10",
    "Remove 9",
    "Finish"])

