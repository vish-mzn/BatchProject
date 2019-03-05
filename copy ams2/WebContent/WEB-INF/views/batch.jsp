<jsp:include page="/includes/navbar.jsp" />
<div class="container">
	<div class="row justify-content-md-center">
		<div class="col-md-10 ">
			<div class="card shadow p-3 mb-5 bg-white rounded">
				<div class="card-body" style="padding: 1.875rem">
					<form action="${pageContext.request.contextPath}/batch/add_batch"
						method="POST" id="form1">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<h4>
										<label for="batch">Batch</label>
									</h4>

									<hr>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="InputEmail1">Batch Id</label>
									<hr>
									<input type="text" class="form-control" id="batch_id"
										name="batchNo" placeholder="Enter batch id">
								</div>
							</div>

							<div class="col-md-6">
								<div class="form-group">
									<label for="course">Select Course</label>
									<hr>
									<select class="form-control" id="course" name="courseId">
<!-- <option id="1" value="1">java</option> -->
									</select>
								</div>
							</div>

						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="begin_date">Begin Date</label>
									<hr>
									<input type="date" class="form-control" id="begin_date"
										name="date">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="weeks">No of Weeks</label>
									<hr>
									<input type="number" class="form-control" id="weeks"
										name="week">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<input type="button" class="btn btn-success"
										value="Add new batch" name="Add" onclick="add()" id="addbatch" />
								</div>
							</div>
						</div>
					</form>
					<div class="row">
						<div class="col-md-12">
							<div class="accordion" id="accordionExample">
								<div class="card">
									<div class="card-header" id="headingOne">
										<h5 class="mb-0">
											<button class="btn btn-link" type="button"
												data-toggle="collapse" data-target="#collapseOne"
												aria-expanded="true" aria-controls="collapseOne"
												onclick="fetchbatch()">View Batch List</button>
										</h5>
									</div>

									<div id="collapseOne" class="collapse "
										aria-labelledby="headingOne" data-parent="#accordionExample">
										<div class="card-body" id="gh">
											<table class="table" id="table_list">
												<thead>
													<tr>
														<th scope="col">#</th>
														<th scope="col">Mark</th>
														<th scope="col">Batch ID</th>
														<th scope="col">Course</th>
														<th scope="col">Begin Date</th>
														<th scope="col">Weeks</th>
														<th scope="col">Participant</th>
													</tr>
												</thead>
												<tbody id="list">
													<%-- <form action="post" id="fetch"
														action="${pageContext.request.contextPath}/delete_batch"></form> --%>

												</tbody>
											</table>
											<div class="row">
												<div class="col-md-12">
													<ul class="pagination">
														<li class="page-item"><button class="page-link"
																onclick="previous()">Previous</button></li>
														<span id="first" class="pagination"></span>
														<li class="page-item"><button class="page-link"
																onclick="next()">Next</button></li>
													</ul>
												</div>
											</div>
											<div class="row">
												<div class="col-md-6">
													<div class="form-group">
														<input type="button" class="btn btn-danger"
															value="Remove Batch" name="remove"
															onclick="delete_batch()" />
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	var form = $('#form1');
	var pageid = 1;
	var p;
	var all_checked = new Array();
	function add() {

		$.ajax({
			type : "POST",
			url : form.attr('action'),
			data : form.serialize(),
			success : function(data) {
				//var result=data;
				console.log("success");
				console.log(data);
				Swal('Success!', 'New Branch created!', 'success')
				//$('#result').attr("value",result);

			},
			error : function(data) {
				Swal('Error!', 'Something is wrong!', 'error')
			}
		});
		/* $('#form1').reset(); */
		return false;
	};
	function previous() {
		if(pageid>1)
			{
		pageid=pageid-1;
			}
		fetchbatch(pageid);
	}
	function next() {
		if(pageid<=p)
			{
		pageid=pageid+1;
			}
		fetchbatch(pageid);
	}
	function fetchbatch(e) {
		var html = '';
		$("#list").empty();

		if ($(e).attr('value') >= 1)
			pageid = $(e).attr('value');
		//$('#gh').load('../WEB-INF/batch.jsp #gh');
		console.log(pageid);
		$
				.ajax({
					url : "${pageContext.request.contextPath}/batch/fetch_batch",
					type : "POST",
					data : {
						pageid : pageid
					},
					success : function(data) {
						console.log(data);
							$("#list").empty();
						var x = data.length;
						for (var i = 0; i < data.length - 1; i++)
							html += '<tr> <th scope="row">'
									+ (i + 1)
									+ '</th><td><input type="checkbox" id="'
									+ (i + 1)
									+ '" value="'
									+ data[i].id
									+ '" onclick="add_checked(this)" ></td><td>'
									+ data[i].id + '</td><td>'
									+ data[i].course.course_name + '</td><td>'
									+ data[i].date + '</td><td>'
									+ data[i].weeks + '</td><td><a href="/hibernate-core/participants/'
									+ data[i].id + '">'+ data[i].size +'</a></tr>';
						$('#list').append(html);
						html = '';
					     p = data[x - 1];
						//console.log(p);
						$("#first").empty();
						for (i = 1; i <= p; i++) {
							html += '<li class="page-item"><button class="page-link" value="'
									+ i
									+ '" onclick="fetchbatch(this)">'
									+ (i)
									+ '</button></li>';

						}
						$('#first').append(html);

					},
					error : function() {
						alert("error");
					}
				});

	};
	function add_checked(batch_id) {
		var flag = false;
		if ($(batch_id).parent().find('input').is(':checked')) {
			for (var i = 0; i < all_checked.length; i++) {
				if (all_checked[i] == batch_id.value) {
					flag = true;
				}
			}
			if (flag == false) {
				all_checked.push(batch_id.value);
			}
		} else if ($(batch_id).parent().find('input').is(':checked') == false) {
			for (var i = 0; i < all_checked.length; i++) {
				if (all_checked.length == 1) {
					all_checked = [];
					//console.log(all_checked)
				} else if (all_checked[i] == batch_id.value) {

					all_checked.splice($.inArray(batch_id.value, all_checked),
							1);
					//console.log(all_checked)
				}
			}
		}
	};

	function delete_batch() {

		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/batch/delete_batch",
			dataType : 'all_checked',
			data : {
				all_checked : all_checked
			},
			success : function(data) {

			},
			error : function(data) {

			}
		});
		/* $('#form1').reset(); */
		//$('#gh').load('add_batch_remove.jsp #gh');
		// fetchbatch();
	};

	 $(document)
			.ready(
					function() {
						var html = '';
						console.log("course");
						var $dropdown = $("#course");
						$
								.ajax({
									url : "${pageContext.request.contextPath}/batch/fetch_course",
									type : "POST",
									success : function(data) {

										for (var i = 0; i < data.length; i++) {
											//console.log(data[i].course_name);
											html += '<option value="'+data[i].id+'">'
													+ data[i].course_name
													+ '</option>';
										}
										setTimeout(function() {
											$('#course').append(html);
										}, 50);

									},
									error : function() {
										alert("error");
									}
								});
					}) 
</script>
<jsp:include page="/includes/footer.jsp" />