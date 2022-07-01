const n = 36;
let currentNum = 1;
let isBigger = false;
let str = "";

function pyramid(n) {

    for (let row = 1; row <= n; row++) {
        for (let column = 1; column <= row; column++) {
            if (currentNum > n){
                console.log(str);
                isBigger = true;
                break;
            }
            str += currentNum + " ";
            currentNum++;
        }
        if (isBigger){
            break;
        }
        console.log(str);
        str = "";
    }
}

pyramid(n);