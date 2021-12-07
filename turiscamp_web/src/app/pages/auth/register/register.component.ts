import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { Subscription } from 'rxjs';
import { User } from 'src/app/models/User';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  
  public validateForm!: FormGroup;
  public subcriptions : Subscription[] = [];
  public sub: Subscription = new Subscription;
  public isSpinning = false;

  constructor(
    private authenticationService : AuthService,
    private fb: FormBuilder, 
    private router: Router, 
    private message: NzMessageService) {}

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      firstName: [null, [Validators.required]],
      lastName: [null, [Validators.required]],
      username: [null, [Validators.required]],
      numberContact: [null, [Validators.required]],
      password: [null, [Validators.required]],
      remember: [null, [Validators.required]]
    });
  }

  submitForm(): void {
    for (const i in this.validateForm.controls) {
      if (this.validateForm.controls.hasOwnProperty(i)) {
        this.validateForm.controls[i].markAsDirty();
        this.validateForm.controls[i].updateValueAndValidity();
      }
    }

      if(!this.validateForm.valid) {
        this.createMessage("warning", "Es necesario llenar todos los campos!");

        // console.log(this.validateForm.controls.username.value);
        if(!this.validateForm.controls.remember.valid){
        this.createMessage("info", "Es necesario aceptar los terminos y condiciones");
        }
        
        return ; 
      }

      
      this.isSpinning = true;
      let user = this.validateForm.value;
      this.subcriptions.push(
        this.authenticationService.register(user).subscribe(
          (response: User) => {
          this.createMessage("sucess",  "Registrado correctamente!");
          this.isSpinning = false;
          this.router.navigateByUrl("/auth/login");
          
        },
          (errorResponse: HttpErrorResponse) => {
            this.isSpinning = false;
            this.createMessage("error",  errorResponse.error.message);             
          }
        )
      );  
  }

  createMessage(type: string, message: string): void {
    this.message.create(type, message);
  }


}
