// taking only letters
function alphabet_order(str) 
{
    const lettersOnly = str.replace(/[^a-zA-Z]/g, '');
    const sorted = lettersOnly.split('').sort().join('');
    return sorted;
}

const str = 'web$mast@er';
const result = alphabet_order(str);
console.log(result); 