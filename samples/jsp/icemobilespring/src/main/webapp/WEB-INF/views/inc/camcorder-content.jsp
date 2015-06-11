<%--
  ~ Copyright 2004-2013 ICEsoft Technologies Canada Corp.
  ~
  ~ Licensed under the Apache License, Version 2.0 (the "License");
  ~ you may not use this file except in compliance with the
  ~ License. You may obtain a copy of the License at
  ~
  ~ http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~ Unless required by applicable law or agreed to in writing,
  ~ software distributed under the License is distributed on an "AS
  ~ IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
  ~ express or implied. See the License for the specific language
  ~ governing permissions and limitations under the License.
  --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.icemobile.org/tags" prefix="mobi"%>
<%@ taglib prefix="push"
	uri="http://www.icepush.org/icepush/jsp/icepush.tld"%>
<form:form id="camcorderform" method="POST"
	enctype="multipart/form-data" modelAttribute="camcorderBean">

	<mobi:largeView><h3>Camcorder</h3></mobi:largeView>

	<mobi:getEnhanced />

	<mobi:fieldsetGroup styleClass="intro">
		<mobi:fieldsetRow>
			The Camcorder allows access to a mobile devices'
			video camera.
		</mobi:fieldsetRow>
	</mobi:fieldsetGroup>

	<mobi:fieldsetGroup>
		<mobi:fieldsetRow>
			<mobi:inputText id="name" name="name" label="Author: "
                value="${camcorderBean.name}"
				placeholder="Your name" />
		</mobi:fieldsetRow>
		<mobi:fieldsetRow>
			<mobi:thumbnail for="video" />
			<mobi:camcorder id="video" style="float:right" />&nbsp;
		</mobi:fieldsetRow>
	</mobi:fieldsetGroup>

	<c:if test="${!mobiClient.SXRegistered}">
		<!-- SX on iOS auto-submits -->
		<mobi:commandButton buttonType='important' styleClass="submit"
			value="Submit" type="submit" />
	</c:if>

	<h3>Camcorder Upload</h3>

	<c:if test="${not empty camcorderMessage}">
		<div id="message" class="success">
			${camcorderMessage}<br />
		</div>
	</c:if>
	<c:if test="${camcorderUploadReady}">
		<mobi:fieldsetGroup>
			<mobi:fieldsetRow>
				<video src="${camcorderUpload}" controls="controls"
					class="imageView" style="min-width: 260px"></video>
				<br>
				<a href="${camcorderUpload}">Play</a>
			</mobi:fieldsetRow>
		</mobi:fieldsetGroup>
	</c:if>
	<c:if test="${not empty camcorderError}">
        <div id="message" class="error">${camcorderError}</div>
    </c:if>

	<mobi:fieldsetGroup styleClass="intro">
		<mobi:fieldsetRow group="true">
			Description
		</mobi:fieldsetRow>
		<mobi:fieldsetRow>
			The Camcorder allows access to a mobile devices'
			video camera. The tag renders a simple button that, when
			pressed, launches the native video camera application on the device.
			Once a video has been taken and accepted, the user is returned to
			the web application.
		</mobi:fieldsetRow>
	</mobi:fieldsetGroup>

</form:form>
<script type="text/javascript">
	MvcUtil.enhanceForm("#camcorderform");

	
</script>