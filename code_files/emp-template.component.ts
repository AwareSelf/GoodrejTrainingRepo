import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-emp-template',
  templateUrl: './emp-template.component.html',
  styleUrls: ['./emp-template.component.css']
})
export class EmpTemplateComponent implements OnInit {


  ename_pattern:string = "^[a-z0-9_-]{5,15}$";

  emp!:{empid:number,empname:string,empsalary:number,empcity:string};

  city = ['Bombay', 'Delhi',
  'Goa', 'UP'];


  constructor()
  {
    this.emp = {empid:1,empname:'rahul',empsalary:20000.9,empcity:'Bombay'}
  }
  ngOnInit(): void {
  }


  addEmp()
  {
    console.log('add emp called');
  }

  onSubmit(f:NgForm)
  {
    console.log('form got submitted');
    console.log(f);
    console.log(f.form.status);
    console.log(f.form.value.empname);

    if(f.form.value.pristine==true && f.form.value.touched==false)
       console.log('no one has yet tried to make entry in the form');
  //    console.log('someone has tried to touch and enter value in form');

    const myname = f.form.value.empname;
    console.log('my name is '+myname);
  }
  resetUserForm(empForm: NgForm): void {
    console.log('reset form called');

    //save data back side

    //then finally reset the form
    empForm.resetForm({
       empid: 2,
       empname: 'Namrata'
    });
 } 

}
