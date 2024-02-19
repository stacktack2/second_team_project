function displayPhotoPreview(input) {
        var preview = document.getElementById('photoPreview');
//        preview.style.display = 'none';  // 미리보기 숨기기

        var files = input.files;
        if (files.length > 0) {
            var reader = new FileReader();

            reader.onload = function (e) {
                preview.src = e.target.result;
                preview.style.display = 'block';  // 미리보기 표시
            }

            reader.readAsDataURL(files[0]);
        }
    }