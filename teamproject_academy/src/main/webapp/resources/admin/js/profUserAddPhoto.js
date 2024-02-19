function displayPhotoPreview(input) {
	if(input.files && input.files[0]){
		int reader = new FileReader();
		reader.onload = function(e){
			document.getElementById('photoPreview').src = e.targer.result;
		};
		reader.readAsDataURL(input.files[0]);
	}else{
		document.getElementById('preview').src = "";
	}
}