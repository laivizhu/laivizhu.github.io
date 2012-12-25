/*
Copyright (c) 2003-2012, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.editorConfig = function( config )
{
	config.height = '300px';
	config.resize_enabled = false;
	config.font_names = 'Arial;Times New Roman;Verdana;宋体;楷体;隶书;黑体;微软雅黑';
	//config.skin='office2003';
	config.toolbar = 'MyToolbar';
 
	config.toolbar_MyToolbar =
	[	
		{ name: 'paragraph', items : [ 'NumberedList','BulletedList','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock', ] },
		{ name: 'links', items : [ 'Link','Unlink','Anchor' ] },
		{ name: 'insert', items : [ 'Table','HorizontalRule','SpecialChar' ] },
		{ name: 'clipboard', items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] },
		
		{ name: 'editing', items : [ 'Find','Replace','SelectAll', ] },
		{ name: 'document', items : [ 'Preview' ] },
		{ name: 'tools', items : [ 'Maximize' ] },
        '/',
		{ name: 'styles', items : [ 'Styles','Format','Font','FontSize' ] },
		{ name: 'basicstyles', items : [ 'Bold','Italic','Strike','-','RemoveFormat' ] },
		{ name: 'colors',  items : [ 'TextColor','BGColor' ] },
		
	];
};
