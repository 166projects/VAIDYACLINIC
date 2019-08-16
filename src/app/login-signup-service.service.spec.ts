import { TestBed } from '@angular/core/testing';

import { LoginSignupServiceService } from './login-signup-service.service';

describe('LoginSignupServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LoginSignupServiceService = TestBed.get(LoginSignupServiceService);
    expect(service).toBeTruthy();
  });
});
