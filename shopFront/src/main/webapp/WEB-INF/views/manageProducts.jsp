<%@ page contentType="text/html;charset=ISO-8859-2" language="java" pageEncoding="ISO-8859-2" %>

<div class="container" style="text-align: right; width: 60%" >
        <div class="col-md-offset-4 col-md-12" align="center">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4>Zarz±dzanie produktami</h4>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="control-label col-md-4" for="name">Wprowad¼ nazwe produktu</label>
                            <div class="col-md-8">

                                <input type="text" name="name" id="name" placeholder="Nazwa produktu" class="form-control"/>
                                <em class="help-block">Prosze wprowadziæ nazwe produktu</em>
                            </div>
                        </div>



                        <div class="form-group">
                            <label class="control-label col-md-4" for="brand">Wprowad¼ wersje</label>
                            <div class="col-md-8">

                                <input type="text" name="brand" id="brand" placeholder="Wersja" class="form-control"/>
                                <em class="help-block">Prosze wprowadziæ wersje produktu</em>
                            </div>
                        </div>




                        <div class="form-group">
                            <div class="col-md-offset-8 col-md-8">

                                <input type="submit" name="submit" id="submit" value="Zatwierd¼" class="btn btn-primary"/>
                            </div>
                        </div>




                    </form>
                </div>
            </div>
        </div>
</div>

