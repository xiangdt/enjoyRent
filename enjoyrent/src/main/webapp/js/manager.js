$('a.nav-link').click(function() {
	$('a.nav-link').each((i, btn) => {
		$(btn).attr('class', 'nav-link');
	})
	$(this).attr('class', 'nav-link active');
})
$('#condition').click(function() {
	$('.card').each((i, div) => {
		$(div).hide();
	})
	$('#conditionlist').fadeIn(500);
})
$('#cars').click(function() {
	$('.card').each((i, div) => {
		$(div).hide();
	})
	$('#carslist').fadeIn(500);
})
$('#users').click(function() {
	$('.card').each((i, div) => {
		$(div).hide();
	})
	$('#userslist').fadeIn(500);
})
$('#works').click(function() {
	$('.card').each((i, div) => {
		$(div).hide();
	})
	$('#worklist').fadeIn(500);
})
$('#addresses').click(function() {
	$('.card').each((i, div) => {
		$(div).hide();
	})
	$('#addresslist').fadeIn(500);
})

$('tbody tr').click(function(e) {
	$('#operating').remove();
	var xx = e.originalEvent.x || e.originalEvent.layerX || 0;
	var yy = e.originalEvent.y || e.originalEvent.layerY || 0;
	console.log(this.id);
	let text = `<div id="operating" class="list-group" style="position:absolute;top:${yy}px;left:${xx}px;">
				<a href="javascript:void(0)" class="list-group-item list-group-item-action btn btn-primary" onclick="modify('${this.id}')">修改</a>
				<a href="javascript:void(0)" class="list-group-item list-group-item-action btn btn-danger">删除</a>
				<a href="javascript:void(0)" class="list-group-item list-group-item-action btn btn-dark" onclick="$('#operating').remove()">关闭</a>
				</div>`;
	$('body').append(text);
})

function modify(obj) {
	$('#operating').remove();
	let titles = $('#' + obj).parent().prev().children().children();
	let contents = $('#' + obj).children();
	console.log(titles)
	console.log(contents)
	let text = `<form id='infochange'>`;
	$(titles).each((i, title) => {
		text += `<div class="form-group">
					<label for="${title.innerText}">${title.innerText}:</label>
					<input type="text" class="form-control" id="${title.innerText}" name="${title.innerText}" value="${contents[i].innerText}">
				</div>`;
	})
	text += `</form>`
	$('.modal-body').empty();
	$('.modal-body').append(text);
	$('#openModal').click();
}