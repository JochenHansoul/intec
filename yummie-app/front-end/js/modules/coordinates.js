"use strict";

// utitily function for lower two functions
const calculateCoordinate = (degrees, minutes, seconds, range) => {
  const N = parseInt(degrees);
  const RESULT = Math.abs(N) + (parseInt(minutes) / 60) + (parseInt(seconds) / 60);
  if (RESULT > range) {
    return (N < 0) ? range * -1 : range;
  } else {
    return (N < 0) ? RESULT * -1 : RESULT;
  }
};

const calculateLattitude = (degrees, minutes, seconds) => {
   return calculateCoordinate(degrees, minutes, seconds, 90);
};

const calculateLongitude = (degrees, minutes, seconds) => {
   return calculateCoordinate(degrees, minutes, seconds, 180);
};

// deprecated (only used for displey purposes)
// verifies if the location coordinates are inside expected range
/*const verifyLocation = (LOCATION, E_LATTITUDE, E_LONGITUDE) => {
  if (LOCATION.lattitude < -90 || LOCATION.lattitude > 90) {
    E_LATTITUDE.innerText = "lattitude must be between -90 and 90";
    if (LOCATION.longitude < -180 || LOCATION.longitude > 180) {
      E_LONGITUDE.innerText = "longitude must be between -180 and 180";
    }
    return false;
  } else if (LOCATION.longitude < -180 || LOCATION.longitude > 180) {
    E_LONGITUDE.innerText = "longitude must be between -180 and 180";
    return false;
  } else {
    return true;
  }
}*/