<jsp:include page="/includes/navbar.jsp" />
<div class="container">
	<div class="row justify-content-md-center">
		<div class="col-md-10 ">
			<div class="card shadow p-3 mb-5 bg-white rounded">
				<div class="card-body" style="padding: 1.875rem">
					<form action="${pageContext.request.contextPath}/kkkkkkkkk" method="GET" id="form1">
						
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<select class="form-control col-md-5" id="interests" name="#" >
										<option value="" disabled selected>Select Courses</option>
										<option value="1" name="FSD Java">FSD Java</option>
										<option value="2" name="MainFrame">MainFrame</option>
										<option value="3" name="Testing">Testing</option>
										<option value="4" name="Advance Java">Advance Java</option>
									</select>
									<hr>
								</div>
							</div>
							<div class="col-md-12">
								<div class="well well-lg" ><h3 id="name_show"></h3></div>
							</div>
						</div>
						<br>
						<div class="row col-md-11">
							<table class="table table-hover">
								<thead>
									<%-- Table Head --%>
									<tr>
										<th>#</th>
										<th>Name</th>
										<th>Employee ID</th>
										<th>Status</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="checkbox"></td>
										<td>John</td>
										<td>999999</td>
										<td>Active</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>Mary</td>
										<td>999999</td>
										<td>Active</td>
									</tr>
									<tr>
										<td><input type="checkbox"></td>
										<td>Jullie</td>
										<td>999999</td>
										<td>Active</td>
									</tr>
								</tbody>
							</table>
						</div>
						
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<input type="button" class="btn btn-success"
										value="Accept" name="Add" onclick="add()" id="addbatch" />
								</div>
							</div>
						</div>
					</form>
					
				</div>
			</div>
		</div>
	</div>
</div>
	
<script type="text/javascript">

	var form = $('#form1');
	$(document).on('change', $("select"), function(e1) {
	   var v= $(this).find('option:selected').text();
	   document.getElementById('name_show').innerHTML=v;
	});
	
</script>
<jsp:include page="/includes/footer.jsp" />