import {StoreDevtoolsModule} from '@ngrx/store-devtools';
export const environment: { production: boolean, endpoint: string, imports: any[] } = {
  production: false,
  // endpoint: 'http://119.110.101.17:8080',
  endpoint: 'http://localhost:8080',
  imports: [
    StoreDevtoolsModule.instrumentOnlyWithExtension({maxAge: 5}),
  ],
};
