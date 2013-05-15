<%--
	User: janlu.sword@gmail.com
	Time: 12-11-11 下午11:08
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>音乐管理</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap/docs.css"/>
	<link rel="stylesheet" href="../css/bootstrap/bootstrap-image-gallery.min.css">
	<link rel="stylesheet" href="../css/jquery/jquery.fileupload-ui.css">
	<link rel="stylesheet" type="text/css" href="../css/jquery/jquery-ui-1.8.5.custom.css"/>
	<style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
	
</head>
<body>
<jsp:include page="../common/navigate.jsp"/>
<div class="container">
<div class="row">
	<div class="span12">
		<form id="fileupload" action="../media/music/upload.nut" method="POST" enctype="multipart/form-data">
		<input type="hidden" id="albumIdInputId" name="albumId">
        <!-- The fileupload-buttonbar contains buttons to add/delete files and start/cancel the upload -->
        <div class="row fileupload-buttonbar">
              <div class="span7">
                  <!-- The fileinput-button span is used to style the file input field as button -->
                  <span class="btn btn-success fileinput-button">
                      <i class="icon-plus icon-white"></i>
                      <span>Add files...</span>
                      <input type="file" name="musics" multiple>
                  </span>
                  <button type="submit" class="btn btn-primary start">
                      <i class="icon-upload icon-white"></i>
                      <span>Start upload</span>
                  </button>
                  <button type="reset" class="btn btn-warning cancel">
                      <i class="icon-ban-circle icon-white"></i>
                      <span>Cancel upload</span>
                  </button>
                  <button type="button" class="btn btn-danger delete">
                      <i class="icon-trash icon-white"></i>
                      <span>Delete</span>
                  </button>
                  <input type="checkbox" class="toggle">
              </div>
              <!-- The global progress information -->
              <div class="span5 fileupload-progress fade">
                  <!-- The global progress bar -->
                  <div class="progress progress-success progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100">
                      <div class="bar" style="width:0%;"></div>
                  </div>
                  <!-- The extended global progress information -->
                  <div class="progress-extended">&nbsp;</div>
              </div>
          </div>
          <!-- The loading indicator is shown during file processing -->
          <div class="fileupload-loading"></div>
          <br>
          <!-- The table listing the files available for upload/download -->
          <table role="presentation" class="table table-striped"><tbody class="files" data-toggle="modal-gallery" data-target="#modal-gallery"></tbody></table>
		</form>
	
		<div id="modal-gallery" class="modal modal-gallery hide fade" data-filter=":odd">
            <div class="modal-header">
                <a class="close" data-dismiss="modal">&times;</a>
                <h3 class="modal-title"></h3>
            </div>
            <div class="modal-body"><div class="modal-image"></div></div>
            <div class="modal-footer">
                <a class="btn modal-download" target="_blank">
                    <i class="icon-download"></i>
                    <span>Download</span>
                </a>
                <a class="btn btn-success modal-play modal-slideshow" data-slideshow="5000">
                    <i class="icon-play icon-white"></i>
                    <span>Slideshow</span>
                </a>
                <a class="btn btn-info modal-prev">
                    <i class="icon-arrow-left icon-white"></i>
                    <span>Previous</span>
                </a>
                <a class="btn btn-primary modal-next">
                    <span>Next</span>
                    <i class="icon-arrow-right icon-white"></i>
                </a>
            </div>
        </div>
	</div>
</div>

</div>
	<script type="text/javascript" src="../js/jquery/jquery-1.8.2.js"></script>
	<script type="text/javascript" src="../js/jquery/jquery-ui-1.8.14.custom.min.js"></script>
	<script type="text/javascript" src="../js/jquery/jquery.form.js"></script>
	<script src="../js/jquery/jquery.ui.widget.js"></script>
	<script src="../js/jquery/tmpl.min.js"></script>
	<script src="../js/jquery/load-image.min.js"></script>
	<script src="../js/jquery/canvas-to-blob.min.js"></script>
	<script type="text/javascript" src="../js/jquery/jquery.fileupload.js"></script>
	<script type="text/javascript" src="../js/jquery/jquery.fileupload-fp.js"></script>
	<script type="text/javascript" src="../js/jquery/jquery.fileupload-ui.js"></script>
	<script type="text/javascript" src="../js/jquery/jquery.fileupload-locale.js"></script>
	<script src="../js/jquery/file-main.js"></script>
	<script type="text/javascript" src="../js/common/sic-basic.js"></script>
	<script id="template-upload" type="text/x-tmpl">
            {% for (var i=0, file; file=o.files[i]; i++) { %}
        <tr class="template-upload fade">
            <td class="preview"><span class="fade"></span></td>
            <td class="name"><span>{%=file.name%}</span></td>
            <td class="size"><span>{%=o.formatFileSize(file.size)%}</span></td>
            {% if (file.error) { %}
            <td class="error" colspan="2"><span class="label label-important">Error</span> {%=file.error%}</td>
            {% } else if (o.files.valid && !i) { %}
            <td>
                <div class="progress progress-success progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0"><div class="bar" style="width:0%;"></div></div>
            </td>
            <td class="start">{% if (!o.options.autoUpload) { %}
                <button class="btn btn-primary">
                    <i class="icon-upload icon-white"></i>
                    <span>Start</span>
                </button>
                {% } %}</td>
            {% } else { %}
            <td colspan="2"></td>
            {% } %}
            <td class="cancel">{% if (!i) { %}
                <button class="btn btn-warning">
                    <i class="icon-ban-circle icon-white"></i>
                    <span>Cancel</span>
                </button>
                {% } %}</td>
        </tr>
        {% } %}
    </script>
    <!-- The template to display files available for download -->
    <script id="template-download" type="text/x-tmpl">
        {% for (var i=0, file; file=o.files[i]; i++) { %}
        <tr class="template-download fade">
            {% if (file.error) { %}
            <td></td>
            <td class="name"><span>{%=file.name%}</span></td>
            <td class="size"><span>{%=o.formatFileSize(file.size)%}</span></td>
            <td class="error" colspan="2"><span class="label label-important">Error</span> {%=file.error%}</td>
            {% } else { %}
            <td class="preview">{% if (file.thumbnail_url) { %}
                <a href="{%=file.url%}" title="{%=file.name%}" rel="gallery" download="{%=file.name%}"><img src="{%=file.thumbnail_url%}"></a>
                {% } %}</td>
            <td class="name">
                <a href="{%=file.url%}" title="{%=file.name%}" rel="{%=file.thumbnail_url&&'gallery'%}" download="{%=file.name%}">{%=file.name%}</a>
            </td>
            <td class="size"><span>{%=o.formatFileSize(file.size)%}</span></td>
            <td colspan="2"></td>
            {% } %}
            <td class="delete">
                <button class="btn btn-danger" data-type="{%=file.delete_type%}" data-url="{%=file.delete_url%}"{% if (file.delete_with_credentials) { %} data-xhr-fields='{"withCredentials":true}'{% } %}>
                        <i class="icon-trash icon-white"></i>
                    <span>Delete</span>
                </button>
                <input type="checkbox" name="delete" value="1">
            </td>
        </tr>
        {% } %}
    </script>
    <script type="text/javascript">
    	$(document).ready(sic.basic.init(function(){
    		var albumId=sic.basic.getUrlVar('id');
    		$('#albumIdInputId').val(albumId);
    	}));
    </script>
</body>
</html>
		