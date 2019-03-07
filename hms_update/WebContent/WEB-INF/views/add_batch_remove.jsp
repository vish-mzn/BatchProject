<jsp:include page="/includes/navbar.jsp" />
<div class="container">
	<div class="row justify-content-md-center">
		<div class="col-md-10">
			<div class="card shadow p-3 mb-5 bg-white rounded">
				<div class="card-body" style="padding: 1.875rem">
				<form action="${pageContext.request.contextPath}/add_batch" method="GET" id="form1">
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
								<input type="text" class="form-control" id="batch_id" name="batchNo"
									placeholder="Enter batch id" >
							</div>
						</div>

						<div class="col-md-6">
							<div class="form-group">
								<label for="course">Select Course</label>
								<hr>
								<select class="form-control" id="course" name="courseId">
									<option value="1">AJ22</option>
									<option value="2">AJ21</option>
									<option value="3">CJ05</option>
									<option value="4">CJ04</option>
									<option value="5">MI23</option>
								</select>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<label for="begin_date">Begin Date</label>
								<hr>
								<input type="date" class="form-control" id="begin_date" name="date">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="weeks">No of Weeks</label>
								<hr>
								<input type="number" class="form-control" id="weeks" name="week">
							</div>
						</div>
					</div>
			
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<input type="button" class="btn btn-success"
									value="Add new batch" name="Add" onclick="add()" id="addbatch"/>
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
												aria-expanded="true" aria-controls="collapseOne">
												View Batch List</button>
										</h5>
									</div>

									<div id="collapseOne" class="collapse "
										aria-labelledby="headingOne" data-parent="#accordionExample">
										<div class="card-body">
											<table class="table">
												<thead>
													<tr>
														<th scope="col">#</th>
														<th scope="col">Batch ID</th>
														<th scope="col">Course</th>
														<th scope="col">Begin Date</th>
														<th scope="col">Weeks</th>
														<th scope="col">Participant</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<th scope="row">1</th>
														<td><input type="checkbox"></td>
														<td>Otto</td>
														<td>@mdo</td>
														<td>@mdo</td>
														<td>@mdo</td>
													</tr>
													<tr>
														<th scope="row">2</th>
														<td><input type="checkbox"></td>
														<td>Otto</td>
														<td>@mdo</td>
														<td>@mdo</td>
														<td>@mdo</td>
													</tr>
													<tr>
														<th scope="row">3</th>
														<td><input type="checkbox"></td>
														<td>Otto</td>
														<td>@mdo</td>
														<td>@mdo</td>
														<td>@mdo</td>
													</tr>
												</tbody>
											</table>
											<div class="row">
												<div class="col-md-6">
													<div class="form-group">
														<input type="button" class="btn btn-danger"
															value="Remove Batch" name="remove" />
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
	
	function add(){
		$.ajax({
		type: form.attr('method'),
		url: form.attr('action'),
		data: form.serialize(),
		success: function(data) {
			//var result=data;
			console.log("success");
			console.log(data);
			Swal(
					  'Success!',
					  'New Branch created!',
					  'success'
					)
			//$('#result').attr("value",result);
			 
		},
		error: function(data){
			Swal(
					  'Error!',
					  'Something is wrong!',
					  'error'
					)
		}
		});
		/* $('#form1').reset(); */
		return false;
	};
</script>

<jsp:include page="/includes/footer.jsp" />