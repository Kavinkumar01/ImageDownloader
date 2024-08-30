The below can be used for getting the urls from the console


const images =document.querySelectorAll('img');
const imageUrls=Array.from(images).map(img=> img.src);
console.log(imageUrls)

or

const images =document.querySelectorAll('img');
images.forEach(img=> console.log(img.src));


for filtering out urls with specific text
images.forEach(img=> {if(img.src.startsWith("https://")) {console.log(img.src)}}); 
