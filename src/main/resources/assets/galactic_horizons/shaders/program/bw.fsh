#version 150

uniform sampler2D DiffuseSampler;

uniform vec4 ColorModulate;

in vec2 texCoord;

vec3 colorA = vec3(0, 0, 4);
vec3 colorB = vec3(4, 0, 0);

uniform vec2 OutSize;

out vec4 fragColor;

void main(){
    fragColor = texture(DiffuseSampler, texCoord) * ColorModulate;
    if(fragColor != vec4(0,0,0,1)){
        fragColor *= vec4(0.1, 0.1, 0.1, 1.0);
    }
}
