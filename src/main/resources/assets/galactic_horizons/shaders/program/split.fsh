#version 150

uniform sampler2D DiffuseSampler;

uniform vec4 ColorModulate;

in vec2 texCoord;

vec3 colorA = vec3(1, 1, 1);
vec3 colorB = vec3(1, 0, 0);

uniform vec2 OutSize;

out vec4 fragColor;

void main(){
    fragColor = texture(DiffuseSampler, texCoord) * ColorModulate;
    vec2 st = gl_FragCoord.xy/OutSize.xy;
    vec3 color = vec3(0.0);

    vec3 pct = vec3(st.x);

    // pct.r = smoothstep(0.0,1.0, st.x);
    // pct.g = sin(st.x*PI);
    // pct.b = pow(st.x,0.5);

    color = mix(colorA, colorB, pct);

    fragColor *= vec4(color,1.0);
}
