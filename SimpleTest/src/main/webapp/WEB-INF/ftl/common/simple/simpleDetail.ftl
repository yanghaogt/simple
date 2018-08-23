<#macro simpleDetail maxWidth=1100>
<@header>
</@header>
<body>
<@top/>
<!-- Main content starts -->

<div class="content">
  	<@left/>
  	<!-- Main bar -->
	<div class="mainbar">
      <@title/>
	  
		<div class="matter">
		<div class="container">
		<div class="col-md-12" style="max-width:${maxWidth}px;">
		<#if code?? && code!="S">
		<div class="alert alert-danger hideit">
          ${msg!}
        </div>
        </#if>
		<div class="row">
		<div class="widget">
<#nested/>
<div id="addModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;"></div>
<div id="editModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;"></div>
		</div>
		</div>
		</div>
		</div>
		</div>
	</div>
   <!-- Mainbar ends -->
	<div class="clearfix"></div>
</div>
<!-- Content ends -->

<@footer/>
</#macro>