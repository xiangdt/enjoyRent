/**
 * @author SONG
 */

$('#carimg').fileinput({
	language: 'zh',
	uploadUrl: 'http://127.0.0.1:8080/upload/',
	allowedFileExtensions: ['jpg', 'gif', 'png'],
	showCaption: true,
	showUpload: true,
	showRemove: true,
	showClose: true,
	layoutTemplates: {
		actionDelete: ''
	},
	browseClass: 'btn btn-primary'
});
