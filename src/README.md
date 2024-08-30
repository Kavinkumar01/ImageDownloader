If facing any issue with path the below can be used to find 
    String filePath = "F:/fairytail/Pro/test.txt"; // Path to your text file
    Path pathToFile = Paths.get(filePath);
    System.out.println("path: "+pathToFile.toAbsolutePath());

    
The below can be used for getting the urls from the console


const images =document.querySelectorAll('img');
const imageUrls=Array.from(images).map(img=> img.src);
console.log(imageUrls)

or

const images =document.querySelectorAll('img');
images.forEach(img=> console.log(img.src));


for filtering out urls with specific text
images.forEach(img=> {if(img.src.startsWith("https://")) {console.log(img.src)}}); 


{
const images =document.querySelectorAll('img');
const imageUrls=Array.from(images).map(img=> img.src);
const urlsString = imageUrls.join('/n');
const blob=new Blob([urlsString], {type:'text/plain'});
const a=document.createElement('a');
a.href= URL.createObjectURL(blob);
a.download='image-urls.txt';

document.body.appendChild(a);
a.click();
document.body.removeChild(a);
}

{
const images =document.querySelectorAll('img');
var imageUrls=[];
for(var i=0;i<images.length;i++){
    if(images[i].src.startsWith("https://")){
    imageUrls.push(images[i].src);
    }
}
const imageUrlsText = imageUrls.join('\n');
const blob=new Blob([imageUrlsText], {type:'text/plain'});
const a=document.createElement('a');
a.href= URL.createObjectURL(blob);
a.download='image-urls.txt';

document.body.appendChild(a);
a.click();
document.body.removeChild(a);
}
