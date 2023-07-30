<!DOCTYPE html>
<html>
<head>
	<title>Certificate Generator</title>
</head>
<body>
	<h1>Certificate Generator</h1>
	<form action="CertificateGeneratorServlet" method="post">
		<label for="name">Name:</label>
		<input type="text" id="name" name="name" required><br><br>
		<label for="dob">Date of Birth:</label>
		<input type="date" id="dob" name="dob" required><br><br>
		<label for="school">School:</label>
		<input type="text" id="school" name="school" required><br><br>
		<label for="certificate_type">Certificate Type:</label>
		<select id="certificate_type" name="certificate_type" required>
			<option value="Kannada Medium Certificate">Kannada Medium Certificate</option>
			<option value="Leaving Certificate">Leaving Certificate</option>
			<option value="Progress Report">Progress Report</option>
			<option value="Rural Certificate">Rural Certificate</option>
			<option value="Study Certificate">Study Certificate</option>
			<option value="Character Certificate">Character Certificate</option>
		</select><br><br>
		<input type="submit" value="Generate Certificate">
	</form>
</body>
</html>
