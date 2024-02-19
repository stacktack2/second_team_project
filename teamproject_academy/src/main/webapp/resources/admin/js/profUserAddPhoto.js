function displayPhotoPreview(event){
	let reader = new FileReader();
	
	reader.onload = function(event){
		int img = document.createElement("img");
		img.setAttribute("src", event.target.result);
		document.querySelector("div#photoPreview").appendChild(img);
	};
	
	reader.readAsDataURL(event.target.files[0]);
}