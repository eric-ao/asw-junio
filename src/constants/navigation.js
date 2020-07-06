/**
 * Object mapping of known possible inboxes for the user
 */
export const NavigationItems = [
  {
    id: 'welcome',
    icon: '/asw-junio/img/icon/apps.svg',
    label: 'navBar.welcome',
    to: '/asw-junio/welcome'
  },
  {
    id: 'profile',
    icon: '/asw-junio/img/people.svg',
    label: 'navBar.profile',
    to: '/asw-junio/profile'
  },
  {
    id: 'map',
    icon: '/asw-junio/img/mapa.jpg',
    label: 'navBar.map',
    to: '/asw-junio/map'
  }
  ,
  {
    id: 'friends',
    icon: '/asw-junio/img/amigos.png',
    label: 'navBar.friends',
    to: '/asw-junio/friends'
  },
  
  {
    id: 'ayuda',
    icon: '/asw-junio/img/LogoAyuda.jpg',
    label: 'Ayuda',
    to: '/asw-junio/ayuda'
  }
];

export const ProfileOptions = [
  

  {
    label: 'navBar.logOut',
    onClick: 'logOut',
    icon: 'lock'
  }
];
