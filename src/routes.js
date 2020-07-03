import React, { Fragment } from 'react';
import { PrivateLayout, PublicLayout, NotLoggedInLayout } from '@layouts';
import { BrowserRouter as Router, Switch, Redirect } from 'react-router-dom';

import {
  Login,
  Register,
  PageNotFound,
  Welcome,
  RegistrationSuccess,
  Profile,
  MapComponent,
  MisAmigosComponent,
  AyudaComponent
  
} from './containers';






const privateRoutes = [
  {
    id: 'home',
    path: '/asw-junio/',
    component: Welcome
  },
  {
    id: 'welcome',
    path: '/asw-junio/welcome',
    component: Welcome
  },
  {
    id: 'profile',
    path: '/asw-junio/profile',
    component: Profile
  },
  {
    id: 'map',
    path: '/asw-junio/map',
    component: MapComponent
  },
  {
    id: 'friends',
    path: '/asw-junio/friends',
    component: MisAmigosComponent
  },
  {
    id: 'ayuda',
    path: '/asw-junio/ayuda',
    component: AyudaComponent
  }
];

const Routes = () => (
  <Router>
    <Fragment>
      <Switch>
        <NotLoggedInLayout component={Login} path="/asw-junio/login" exact />
        <NotLoggedInLayout component={Register} path="/asw-junio/register" exact />
        <NotLoggedInLayout path="/asw-junio/register/success" component={RegistrationSuccess} exact />
        <PublicLayout path="/asw-junio/404" component={PageNotFound} exact />
        <Redirect from="/" to="/asw-junio/welcome" exact />
        <PrivateLayout path="/asw-junio/" routes={privateRoutes} />
        <Redirect from="/login" to="/asw-junio/login" exact />
        <Redirect from= "/asw-junio/#" to="/asw-junio/welcome" exact/>
       
        
      </Switch>
    </Fragment>
  </Router>
);

export default Routes;
